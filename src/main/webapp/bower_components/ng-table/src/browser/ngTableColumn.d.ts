/// <reference types="angular" />
/**
 * ngTable: Table + Angular JS
 *
 * @author Vitalii Savchuk <esvit666@gmail.com>
 * @url https://github.com/esvit/ng-table/
 * @license New BSD License <http://creativecommons.org/licenses/BSD/>
 */
import { IScope } from 'angular';
import { IColumnDef, IDynamicTableColDef } from './public-interfaces';
/**
 * @private
 * Definition of the service used to construct a table $column used by {@link ngTable ngTable} directive
 */
export interface IColumnBuilder {
    /**
     * Creates a $column for use within a header template
     *
     * @param column the initial definition for $column to build
     * @param defaultScope the $scope to supply to the $column getter methods when not supplied by caller
     * @param columns a reference to the $columns array to make available on the context supplied to the
     * $column getter methods
     */
    buildColumn(column: IColumnDef | IDynamicTableColDef, defaultScope: IScope, columns: Array<IColumnDef | IDynamicTableColDef>): IColumnDef | IDynamicTableColDef;
}
/**
 * @private
 * Service to construct a $column definition used by {@link ngTable ngTable} directive
 */
export declare function ngTableColumn(): IColumnBuilder;
