/// <reference types="angular" />
/// <reference types="angular-mocks" />
/**
 * ngTable: Table + Angular JS
 *
 * @author Vitalii Savchuk <esvit666@gmail.com>
 * @url https://github.com/esvit/ng-table/
 * @license New BSD License <http://creativecommons.org/licenses/BSD/>
 */
import { IAttributes, IAugmentedJQuery, ICompileService, IDocumentService, IParseService, IScope, ITimeoutService } from 'angular';
import { DataResults, GroupedDataResults, INgTableParams, IEventsChannel, IPageButton, ITableParamsConstructor } from '../core';
import { IColumnDef, ITableInputAttributes } from './public-interfaces';
import { IColumnBuilder } from './ngTableColumn';
/**
 * @private
 */
export interface ITableScope<T> extends IScope {
    $columns: IColumnDef[];
    $loading: boolean;
    $filterRow: {
        disabled: boolean;
    };
    $data?: DataResults<T>;
    $groups?: GroupedDataResults<T>;
    $groupRow: {
        show: boolean;
    };
    show_filter: boolean;
    pages: IPageButton[];
    templates: {
        header: string;
        pagination: string;
    };
    params: INgTableParams<T>;
}
/**
 * The controller for the {@link ngTable ngTable} and {@link ngTableDynamic ngTableDynamic} directives
 */
export declare function ngTableController<T>($scope: ITableScope<T>, NgTableParams: ITableParamsConstructor<T>, $timeout: ITimeoutService, $parse: IParseService, $compile: ICompileService, $attrs: IAttributes & ITableInputAttributes, $element: IAugmentedJQuery, $document: IDocumentService, ngTableColumn: IColumnBuilder, ngTableEventsChannel: IEventsChannel): void;
