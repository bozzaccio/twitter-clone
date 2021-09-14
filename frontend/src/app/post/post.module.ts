
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PostRoutingModule } from './post-routing.module';
import { PostDashboardComponent } from './component/post-dashboard/post-dashboard.component';
import { SharedModule } from '../shared/shared.module';
import { PostListComponent } from './component/post-list/post-list.component';
import { PostComponent } from './component/post/post.component';
import { PostFormComponent } from './component/post-form/post-form.component';
import { MatBadgeModule } from '@angular/material/badge';
import { MatIconModule } from '@angular/material/icon';
import { MatFormFieldModule } from '@angular/material/form-field';
import { ReactiveFormsModule } from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import { HttpClientModule } from '@angular/common/http';
import { MatButtonModule } from '@angular/material/button';
import {MatMenuModule} from '@angular/material/menu';

@NgModule({
  declarations: [
    PostDashboardComponent,
    PostComponent,
    PostListComponent,
    PostFormComponent
  ],
  imports: [
    CommonModule,
    PostRoutingModule,
    SharedModule,
    MatBadgeModule,
    MatIconModule,
    MatFormFieldModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatInputModule,
    MatButtonModule,
    MatMenuModule
  ]
})
export class PostModule { }
