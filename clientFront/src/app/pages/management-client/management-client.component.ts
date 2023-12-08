import { Client } from './../../model/client';
import { ClientService } from './../../service/client.service';
import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import * as moment from 'moment';

import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-management-client',
  templateUrl: './management-client.component.html',
  styleUrls: ['./management-client.component.css']
})
export class ManagementClientComponent implements OnInit {

  form: FormGroup;
  text: string;
  client: Client;
  sharedKey: string;

  clientRegister: string = "Create New Client";
  clientUpdate: string = "Edit Client";

  constructor(
    public _dialogRef: MatDialogRef<ManagementClientComponent>,
    @Inject(MAT_DIALOG_DATA) public data: Client,
    private _formBuilder: FormBuilder,
    private _clientService: ClientService
  ) { }

  ngOnInit(): void {
    this.initForm();
    this.initForm();
  }

  emptyForm() {
    this.form = this._formBuilder.group({
      bussinessId: [null, [Validators.required]],
      email: [null, [Validators.required, Validators.email]],
      phone: [null, [Validators.required]],
      startDate: [moment().format('YYYY-MM-DD'), [Validators.required]],
      endDate: [moment().format('YYYY-MM-DD'), [Validators.required]]
    });
  }

  initForm() {
    this.emptyForm();

    this.client = { ...this.data }
    this.text = this.clientRegister;

    if (this.data != null) {
      this.editForm();
      return;
    }
    this.client.id = 0;
  }

  editForm() {
    this.text = this.clientUpdate;
    this.bussinessId.setValue(this.client.bussinessId);
    this.email.setValue(this.client.email);
    this.phone.setValue(this.client.phone);
    this.startDate.setValue(this.client.startDate);
    this.endDate.setValue(this.client.endDate);
  }

  operate() {
    const client = {
      id: this.client.id,
      sharedKey: this.makeSharedKey(),
      bussinessId: this.bussinessId.value,
      email: this.email.value,
      phone: this.phone.value,
      dataAdded: "",
      startDate: moment(this.startDate.value).format('YYYY-MM-DD'),
      endDate: moment(this.endDate.value).format('YYYY-MM-DD')
    }
    this._clientService.save(client).subscribe(() => {
      console.log("guardado");
      this._dialogRef.close(true);
    });
  }

  makeSharedKey() {
    let input: string = this.email.value;
    let splitInput: string[] = input.split('@');
    return splitInput[0];
  }

  // ------------------------------ get form ------------------------------
  get bussinessId() {
    return this.form.get("bussinessId")!
  }

  get email() {
    return this.form.get("email")!
  }

  get phone() {
    return this.form.get("phone")!
  }

  get startDate() {
    return this.form.get("startDate")!
  }

  get endDate() {
    return this.form.get("endDate")!
  }

}
