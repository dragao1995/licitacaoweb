/// <reference types="angular" />
/**
 * ngTable: Table + Angular JS
 *
 * @author Vitalii Savchuk <esvit666@gmail.com>
 * @url https://github.com/esvit/ng-table/
 * @license New BSD License <http://creativecommons.org/licenses/BSD/>
 */
import * as ng1 from 'angular';
import { IEventsChannel } from './public-interfaces';
/**
 * Implementation of the {@link IEventsChannel IEventsChannel} interface
 * @ngdoc service
 */
export declare function ngTableEventsChannel($rootScope: ng1.IRootScopeService): IEventsChannel;
