import { Reaction, ReactionType } from './../../../shared/interface/reaction.interface';
import { ReactionService } from './../../service/reaction.service';
import { PostFormComponent } from './../post-form/post-form.component';
import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { first } from 'rxjs/operators';
import { Post } from 'src/app/shared/interface/post.interface';
import { PostService } from '../../service/post.service';
import { PostFormModalComponent } from '../post-form-modal/post-form-modal.component';

@Component({
  selector: 'app-post-dashboard',
  templateUrl: './post-dashboard.component.html',
  styleUrls: ['./post-dashboard.component.scss']
})
export class PostDashboardComponent implements OnInit {

  public postList: Post[] = [];

  constructor(private _postService: PostService,
    private _reactionService: ReactionService,
    private _dialogService: MatDialog) {
  }

  ngOnInit(): void {
    this._loadPosts();
  }

  public onPostDelete(dto: Post) {

    if (dto && dto.id)
      this._postService.delete(dto.id).pipe(first()).subscribe(_ => this._loadPosts());
  }

  public onPostUpdate(dto: Post): void {

    const updateModal = this._dialogService.open(PostFormModalComponent, {
      data: { post: dto }
    });


    updateModal.afterClosed().pipe(first()).subscribe(result => {
      this._invokeUpdate(result);
    });
  }

  public onPostCreate(dto: Post): void {

    this._postService.create(dto)
      .pipe(first())
      .subscribe((post: Post) => this._loadPosts());
  }

  public onReactionEvent(reaction: Reaction): void {
    if (reaction)
      this._reactionService.create(reaction).pipe(first()).subscribe(_ => this._loadPosts());
  }

  private _loadPosts(): void {
    this._postService.getAll()
      .pipe(first())
      .subscribe((postList: Post[]) => this.postList = postList);
  }

  private _invokeUpdate(dto: Post): void {

    if (dto && dto.id)
      this._postService.update(dto).pipe(first()).subscribe(_ => this._loadPosts());
  }
}
