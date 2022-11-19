import { Component, OnInit } from '@angular/core';
import { AttachmentService } from 'src/app/service/attachment.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-attachment',
  templateUrl: './attachment.component.html',
  styleUrls: ['./attachment.component.css']
})
export class AttachmentComponent implements OnInit {

  shortLink: string = "";
  loading: boolean = false; // Flag variable
  file: File = null; // Variable to store file

  // Inject service 
  constructor(private fileUploadService: AttachmentService) { }

  ngOnInit(): void {
  }

  // On file Select
  onChange(event) {
      this.file = event.target.files[0];
  }

  // OnClick of button Upload
  onUpload() {
      this.loading = !this.loading;
      console.log(this.file);
      Swal.fire(
        'File has been Uploaded!',
        '',
        'success'
      )
      this.fileUploadService.upload(this.file).subscribe(
          (event: any) => {
              if (typeof (event) === 'object') {

                  // Short link via api response
                  this.shortLink = event.link;

                  this.loading = false; // Flag variable 
              }
          }
      );
  }

}
