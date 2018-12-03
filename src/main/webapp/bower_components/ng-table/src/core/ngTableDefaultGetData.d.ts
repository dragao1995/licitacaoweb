/// <reference types="angular" />
/**
 * ngTable: Table + Angular JS
 *
 * @author Vitalii Savchuk <esvit666@gmail.com>
 * @url https://github.com/esvit/ng-table/
 * @license New BSD License <http://creativecommons.org/licenses/BSD/>
 */
import * as ng1 from 'angular';
import { IDefaultGetDataProvider, IDefaultGetData } from './public-interfaces';
/**
 * Allows for the configuration of the ngTableDefaultGetData service.
 *
 * Set filterFilterName to the name of a angular filter that knows how to apply the values returned by
 * `NgTableParams.filter()` to restrict an array of data.
 *
 * Set sortingFilterName to the name of a angular filter that knows how to apply the values returned by
 * `NgTableParams.orderBy()` to sort an array of data.
 *
 * Out of the box the `ngTableDefaultGetData` service will be configured to use the angular `filter` and `orderBy`
 * filters respectively
 *
 * @ngdoc provider
 */
export declare class ngTableDefaultGetDataProvider implements IDefaultGetDataProvider {
    filterFilterName: string;
    sortingFilterName: string;
    $get: ($filter: ng1.IFilterService) => IDefaultGetData<any>;
    constructor();
}
