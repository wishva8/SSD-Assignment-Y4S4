import { Component, OnInit } from '@angular/core';
import { NbToastrService } from '@nebular/theme';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from 'src/app/entity/user';
import { Message } from 'src/app/entity/message';
import { MessageService } from 'src/app/service/message.service';

@Component({
  selector: 'app-message',
  templateUrl: './message.component.html',
  styleUrls: ['./message.component.css']
})
export class MessageComponent implements OnInit {
  proId: number;
  user: User[];
  issueForm: FormGroup;
  message: Message = new Message();
  submitted = false;
  constructor(
    private messageService: MessageService,
    private route: ActivatedRoute,
    private formBuilder: FormBuilder,
    private router: Router,
    private toastrService: NbToastrService) { }

  ngOnInit() {

    this.issueForm = this.formBuilder.group({
      identifier: ['', Validators.required],
      description: ['', Validators.required]
    });

  }

  saveIssue(): void {
    const data = {

      identifier: this.message.identifier,
      description: this.message.description,
    }

    this.messageService.createMessage(data).subscribe(
      response => {
        console.log(response);
        this.submitted = true;
      }
    )
  }
  isFieldValid(field: string) {
    return !this.issueForm.get(field).valid && this.issueForm.get(field).touched;
  }
  validateAllFormFields(formGroup: FormGroup) {
    Object.keys(formGroup.controls).forEach(field => {
      console.log(field);
      const control = formGroup.get(field);
      if (control instanceof FormControl) {
        control.markAsTouched({ onlySelf: true });
      } else if (control instanceof FormGroup) {
        this.validateAllFormFields(control);
      }
    });
  }
  onSubmit() {
    if (this.issueForm.valid) {
      this.saveIssue();
      this.toastrService.success(status || '', `Successfully Message Saved!`);
      this.router.navigate(['/message-list']);
    } else {
      this.validateAllFormFields(this.issueForm);
      this.toastrService.danger(status || '', `Failed to save Message!`);
    }
  }
  reset() {
    this.router.navigate(['/dashboard']);
  }

}
