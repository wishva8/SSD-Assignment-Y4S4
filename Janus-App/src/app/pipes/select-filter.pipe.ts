import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'selectFilter'
})
export class SelectFilterPipe implements PipeTransform {

  transform(value: any, args?: any): any {
    return null;
  }

}
