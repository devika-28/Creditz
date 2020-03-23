import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FormsModule, ReactiveFormsModule, NgForm,} from '@angular/forms';



const routes: Routes = [];

@NgModule({
  imports: [
    RouterModule.forRoot(routes),
    ReactiveFormsModule,
    FormsModule,
    ],
  exports: [RouterModule, NgForm]
})
export class AppRoutingModule { }
