/// <reference types="angular" />
/**
 * ngTable: Table + Angular JS
 *
 * @author Vitalii Savchuk <esvit666@gmail.com>
 * @url https://github.com/esvit/ng-table/
 * @license New BSD License <http://creativecommons.org/licenses/BSD/>
 */
import { IDirective, IQService, IParseService } from 'angular';
/**
 * Directive that instantiates {@link ngTableController ngTableController}.
 * @ngdoc directive
 * @name ngTable
 * @example
 *
 * ```html
 * <table ng-table="$ctrl.tableParams" show-filter="true" class="table table-bordered">
 *  <tr ng-repeat="user in $data">
 *      <td data-title="'Name'" sortable="'name'" filter="{ 'name': 'text' }">
 *          {{user.name}}
 *      </td>
 *      <td data-title="'Age'" sortable="'age'" filter="{ 'age': 'text' }">
 *          {{user.age}}
 *      </td>
 *  </tr>
 * </table>
 * ```
 */
export declare function ngTable($q: IQService, $parse: IParseService): IDirective;
