import { FormControl, FormGroup, Validators } from "@angular/forms";

export class AuctionFormGroup extends FormGroup {
  constructor() {
    super({
      name: new FormControl("", [
        Validators.required,
        Validators.pattern(/^[A-Za-z]{2,15}$/),
      ]),
      description: new FormControl("", [
        Validators.required,
        Validators.pattern(/^[A-Za-z]{2,500}$/),
      ]),
      photoUrl: new FormControl(),
      startPrice: new FormControl("", [Validators.required, Validators.min(1)]),
    });
  }
}
