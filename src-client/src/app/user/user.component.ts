import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { UserApiService } from '../core/services/user-api.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css'],
})
export class UserComponent implements OnInit {
  users: any;
  user: any = {};
  userForCreate: any;
  userForm: FormGroup;
  createUserForm: FormGroup;
  userId: number;
  displayBasic: boolean = false;

  constructor(private userApi: UserApiService, private fb: FormBuilder) {}

  ngOnInit(): void {
    this.listUsers();
    this.buildForm(this.user, this.userForCreate);
  }

  listUsers() {
    this.userApi.getAllUsers().subscribe((res) => {
      console.log(res);
      this.users = res;
    });
  }

  buildForm(user: any, user2: any) {
    this.userForm = this.fb.group({
      name: [user ? user.name : ''],
      surname: [user ? user.surname : ''],
    });

    this.createUserForm = this.fb.group({
      name: [user2 ? user2.name : ''],
      surname: [user2 ? user2.surname : ''],
    });
  }

  editUser(id: number) {
    this.userId = id;
    this.userApi.getUserById(id).subscribe((res) => {
      this.user = res;
      console.log(res);

      this.buildForm(this.user, this.userForCreate);
    });
  }
  clearForm() {
    this.userForm.reset();
    this.userId = undefined;
  }

  createUser() {
    let user = {
      name: this.createUserForm.controls['name'].value.trim(),
      surname: this.createUserForm.controls['surname'].value.trim(),
    };

    this.userApi.createUser(user).subscribe((res) => {
      this.listUsers();
      this.createUserForm.reset();
    });
  }

  editingUser() {
    let name: string = this.userForm.controls['name'].value;
    name.trim();
    let surname: string = this.userForm.controls['surname'].value;
    surname.trim();
    let user = { 
      idUser: this.userId,
      name: name,
      surname: surname,
    };

    if (this.userId) {
      this.userApi.updateUser(this.userId, user).subscribe((res) => {
        this.listUsers();
        this.userForm.reset();
        this.userId = undefined;
      });
    }
  }

  deleteUser() {
    this.userApi.deleteUserById(this.userId).subscribe((res) => {
      this.listUsers();
      this.displayBasic = false;
    });
  }

  showBasicDialog(id: number) {
    this.userId = id;
    this.displayBasic = true;
  }
}
