import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Post } from 'src/app/shared/interface/post.interface';

@Component({
  selector: 'app-post-form',
  templateUrl: './post-form.component.html',
  styleUrls: ['./post-form.component.scss']
})
export class PostFormComponent implements OnInit {

  @Output() onPostEvent: EventEmitter<any> = new EventEmitter();

  public postForm!: FormGroup;

  constructor(private _formBuilder: FormBuilder) {
    this.postForm = this._buildPostForm();
  }

  ngOnInit(): void {
  }

  public onFormSubit(): void {

    const dto: Post = this.postForm.value;

    this.onPostEvent.emit(dto);
  }

  private _buildPostForm(): FormGroup {
    return this._formBuilder.group({
      id: [null],
      version: [null],
      creationTimestamp: [null],
      updateTimestamp: [null],
      creationUser: [null],
      updateUser: [null],
      title: [null, Validators.required],
      description: [null, Validators.required],
    })
  }

  private _setCategoryFormValues(dto: Post): void {
    this.postForm?.setValue({
      id: dto?.id,
      version: dto?.version,
      creationTimestamp: dto?.creationTimestamp,
      updateTimestamp: dto?.updateTimestamp,
      creationUser: dto?.creationUser,
      updateUser: dto?.updateUser,
      description: dto?.description,
      title: dto?.title
    })
  }

}
