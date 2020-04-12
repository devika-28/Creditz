import { FormGroup, NG_VALIDATORS, Validator, AbstractControl } from '@angular/forms';
import { Directive, Input } from '@angular/core';

//providers: [{provide: NG_VALIDATORS, useExisting: passwordConfirmationDirective, multi: true}]

@Directive({
    selector: '[appConfirmEqualValidator]',
    providers: [{
        provide: NG_VALIDATORS,
        useExisting :ConfirmEqualValidatorDirective,
        multi: true
    }]
})
export class ConfirmEqualValidatorDirective implements Validator{
@Input()  appConfirmEqualValidator:string;
    validate(control:AbstractControl):{[key:string]:any} |null{
        const controlToCompare =control.parent.get(this.appConfirmEqualValidator);
        if(controlToCompare && controlToCompare.value !== control.value){
            return { 'notEqual':true};

        }
        return null;
    }




}
