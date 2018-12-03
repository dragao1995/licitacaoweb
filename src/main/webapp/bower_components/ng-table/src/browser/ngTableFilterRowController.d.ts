/// <reference types="angular" />
/**
 * ngTable: Table + Angular JS
 *
 * @author Vitalii Savchuk <esvit666@gmail.com>
 * @url https://github.com/esvit/ng-table/
 * @license New BSD License <http://creativecommons.org/licenses/BSD/>
 */
import { IScope } from 'angular';
import { IFilterConfig, IFilterTemplateDef, IFilterTemplateDefMap } from './public-interfaces';
/**
 * @private
 */
export interface IScopeExtensions {
    config: IFilterConfig;
    getFilterCellCss(filter: IFilterTemplateDefMap, layout: string): string;
    getFilterPlaceholderValue(filterDef: string | IFilterTemplateDef, filterKey?: string): string;
}
/**
 * Controller for the {@link ngTableFilterRow ngTableFilterRow} directive
 */
export declare function ngTableFilterRowController($scope: IScope & IScopeExtensions, ngTableFilterConfig: IFilterConfig): void;
