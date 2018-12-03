/// <reference types="angular" />
/// <reference types="angular-mocks" />
/**
 * ngTable: Table + Angular JS
 *
 * @author Vitalii Savchuk <esvit666@gmail.com>
 * @url https://github.com/esvit/ng-table/
 * @license New BSD License <http://creativecommons.org/licenses/BSD/>
 */
import * as ng1 from 'angular';
import { IDefaults, IDefaultGetData, IEventsChannel, IParamValues, ISettings, INgTableParams } from './public-interfaces';
/**
 * Implmenentation of the {@link INgTableParams INgTableParams} interface
 * @ngdoc service
 */
export declare function ngTableParamsFactory<T>($q: ng1.IQService, $log: ng1.ILogService, $filter: ng1.IFilterService, ngTableDefaults: IDefaults, ngTableDefaultGetData: IDefaultGetData<any>, ngTableEventsChannel: IEventsChannel): <T>(baseParameters: boolean | IParamValues<T>, baseSettings: ISettings<T>) => INgTableParams<T>;
