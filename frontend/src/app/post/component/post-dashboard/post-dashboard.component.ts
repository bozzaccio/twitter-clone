import { Component, OnInit } from '@angular/core';
import { first } from 'rxjs/operators';
import { Post } from 'src/app/shared/interface/post.interface';
import { PostService } from '../../service/post.service';

@Component({
  selector: 'app-post-dashboard',
  templateUrl: './post-dashboard.component.html',
  styleUrls: ['./post-dashboard.component.scss']
})
export class PostDashboardComponent implements OnInit {

  public postList: Post[] = [];

  constructor(private _postService: PostService) {
  }

  ngOnInit(): void {
    this._loadPosts();
  }

  public onPostSubmit(dto: Post) {

    this._postService.create(dto)
      .pipe(first())
      .subscribe((post: Post) => this._loadPosts());
  }

  private _loadPosts(): void {
    this._postService.getAll()
      .pipe(first())
      .subscribe((postList: Post[]) => this.postList = postList);
  }

}
