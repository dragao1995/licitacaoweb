/// <reference types="angular" />
/**
 * ngTable: Table + Angular JS
 *
 * @author Vitalii Savchuk <esvit666@gmail.com>
 * @url https://github.com/esvit/ng-table/
 * @license New BSD License <http://creativecommons.org/licenses/BSD/>
 */
import { IAngularEvent } from 'angular';
import { IColumnDef } from './public-interfaces';
import { ITableScope } from './ngTableController';
/**
 * @private
 */
export interface IScopeExtensions {
    sortBy($column: IColumnDef, event: IAugmentedMouseEvent): void;
}
/**
 * @private
 */
export interface IAugmentedMouseEvent extends IAngularEvent {
    ctrlKey: boolean;
    metaKey: boolean;
}
/**
 * Controller for the {@link ngTableSorterRow ngTableSorterRow} directive
 */
export declare function ngTableSorterRowController<T>($scope: ITableScope<T> & IScopeExtensions): void;
