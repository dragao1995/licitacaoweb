/**
 * ngTable: Table + Angular JS
 *
 * @author Vitalii Savchuk <esvit666@gmail.com>
 * @url https://github.com/esvit/ng-table/
 * @license New BSD License <http://creativecommons.org/licenses/BSD/>
 */
ngTableGroupRowController.$inject = ['$scope'];
/**
 * Controller for the {@link ngTableGroupRow ngTableGroupRow} directive
 */
export function ngTableGroupRowController($scope) {
    var groupFns = [];
    init();
    function init() {
        $scope.getGroupables = getGroupables;
        $scope.getGroupTitle = getGroupTitle;
        $scope.getVisibleColumns = getVisibleColumns;
        $scope.groupBy = groupBy;
        $scope.isSelectedGroup = isSelectedGroup;
        $scope.toggleDetail = toggleDetail;
        $scope.$watch('params.group()', setGroup, true);
    }
    function changeSortDirection() {
        var newDirection;
        if ($scope.params.hasGroup($scope.$selGroup, 'asc')) {
            newDirection = 'desc';
        }
        else if ($scope.params.hasGroup($scope.$selGroup, 'desc')) {
            newDirection = '';
        }
        else {
            newDirection = 'asc';
        }
        $scope.params.group($scope.$selGroup, newDirection);
    }
    function findGroupColumn(groupKey) {
        return $scope.$columns.filter(function ($column) {
            return $column.groupable($scope) === groupKey;
        })[0];
    }
    function getGroupTitle(group) {
        return isGroupingFunc(group) ? group.title : group.title($scope);
    }
    function getGroupables() {
        var groupableCols = $scope.$columns.filter(function ($column) {
            return !!$column.groupable($scope);
        });
        return groupFns.concat(groupableCols);
    }
    function getVisibleColumns() {
        return $scope.$columns.filter(function ($column) {
            return $column.show($scope);
        });
    }
    function groupBy(group) {
        if (isSelectedGroup(group)) {
            changeSortDirection();
        }
        else {
            if (isGroupingFunc(group)) {
                $scope.params.group(group);
            }
            else {
                // it's OK, we know that groupable will return a string
                // this is guaranteed by getGroupables returning only
                // columns that return (truthy) strings
                $scope.params.group(group.groupable($scope));
            }
        }
    }
    function isGroupingFunc(val) {
        return typeof val === 'function';
    }
    function isSelectedGroup(group) {
        if (isGroupingFunc(group)) {
            return group === $scope.$selGroup;
        }
        else {
            return group.groupable($scope) === $scope.$selGroup;
        }
    }
    function setGroup(grouping) {
        var existingGroupCol = findGroupColumn($scope.$selGroup);
        if (existingGroupCol && existingGroupCol.show.assign) {
            existingGroupCol.show.assign($scope, true);
        }
        if (isGroupingFunc(grouping)) {
            groupFns = [grouping];
            $scope.$selGroup = grouping;
            $scope.$selGroupTitle = grouping.title;
        }
        else {
            // note: currently only one group is implemented
            var groupKey = Object.keys(grouping || {})[0];
            var groupedColumn = findGroupColumn(groupKey);
            if (groupedColumn) {
                $scope.$selGroupTitle = groupedColumn.title($scope);
                $scope.$selGroup = groupKey;
                if (groupedColumn.show.assign) {
                    groupedColumn.show.assign($scope, false);
                }
            }
        }
    }
    function toggleDetail() {
        $scope.params.settings().groupOptions.isExpanded = !$scope.params.settings().groupOptions.isExpanded;
        return $scope.params.reload();
    }
}
//# sourceMappingURL=ngTableGroupRowController.js.map