import { Client } from './../../model/client';
import { ClientService } from './../../service/client.service';
import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ManagementClientComponent } from '../management-client/management-client.component';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  displayedColumns: string[] = ['key', 'id', 'email', 'phone', 'dataAdded', 'edit'];

  client: Client[] = [];
  form: FormGroup;
  clientRegister: string = "Client Register";
  clientUpdate: string = "Client Update";
  export: string;

  dataSource: MatTableDataSource<Client> = new MatTableDataSource<Client>(this.client)

  constructor(
    private _clientService: ClientService,
    private _dialog: MatDialog,
    private _snackBar: MatSnackBar,
  ) { }

  ngOnInit(): void {
    this.getAll();
    this.formSearch();
  }

  getAll() {
    this._clientService.getAll().subscribe(data => {
      console.log(data.data);
      this.client = data.data;
      this.dataSource = new MatTableDataSource(this.client)
    });
  }

  openDialog(client: Client | null) {
    let text = "";
    client == null ? text = this.clientRegister : text = this.clientUpdate;

    let dialogRef = this._dialog.open(ManagementClientComponent, {
      height: '500px',
      width: '400px',
      data: client
    });
    dialogRef.afterClosed().subscribe(res => {
      if (res) {
        this._snackBar.open(text, "✔️", {
          duration: 2000,
          verticalPosition: "top",
          horizontalPosition: "right"
        });
        this.getAll();
      }
    });
  }

  formSearch() {
    this.form = new FormGroup({
      sharedKey: new FormControl("")
    });
  }

  search() {
    let sharedKey = this.form.controls["sharedKey"].value;
    if(sharedKey == ""){ return; }
    this.export = sharedKey;
    this._clientService.search(sharedKey).subscribe(data => {
      console.log(data.data);
      this.client = data.data;
      this.dataSource = new MatTableDataSource(this.client)
      this.form.controls["sharedKey"].setValue("");
    });
  }
}
