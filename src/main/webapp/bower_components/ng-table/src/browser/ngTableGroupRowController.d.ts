/// <reference types="angular" />
/**
 * ngTable: Table + Angular JS
 *
 * @author Vitalii Savchuk <esvit666@gmail.com>
 * @url https://github.com/esvit/ng-table/
 * @license New BSD License <http://creativecommons.org/licenses/BSD/>
 */
import { IPromise } from 'angular';
import { DataResult, IGroupingFunc } from '../core';
import { IColumnDef } from './public-interfaces';
import { ITableScope } from './ngTableController';
/**
 * @private
 */
export interface IScopeExtensions<T> {
    $selGroup: IGroupingFunc<any> | string;
    $selGroupTitle: string;
    getGroupables(): Array<IGroupingFunc<any> | IColumnDef>;
    getGroupTitle(group: IGroupingFunc<any> | IColumnDef): string;
    getVisibleColumns(): IColumnDef[];
    groupBy(group: IGroupingFunc<any> | IColumnDef): void;
    isSelectedGroup(group: IGroupingFunc<any> | IColumnDef): boolean;
    toggleDetail(): IPromise<Array<DataResult<T>>>;
}
/**
 * Controller for the {@link ngTableGroupRow ngTableGroupRow} directive
 */
export declare function ngTableGroupRowController<T>($scope: ITableScope<T> & IScopeExtensions<T>): void;
