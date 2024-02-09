import { Component, inject } from "@angular/core";
import { MatDialogModule, MatDialogRef } from "@angular/material/dialog";
import { MatButtonModule } from "@angular/material/button";
import { MatInputModule } from "@angular/material/input";
import { PhotoPreviewComponent } from "../photo-preview/photo-preview.component";
import {FormControl, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {AuctionsService} from "../../services/auctions.service";

@Component({
  selector: "app-modal-create-auction",
  standalone: true,
  imports: [
    MatDialogModule,
    MatButtonModule,
    MatInputModule,
    PhotoPreviewComponent,
    ReactiveFormsModule,
  ],
  templateUrl: "./modal-create-auction.component.html",
  styleUrl: "./modal-create-auction.component.scss",
})
export class ModalCreateAuctionComponent {
  private dialogRef: MatDialogRef<ModalCreateAuctionComponent> = inject(
    MatDialogRef<ModalCreateAuctionComponent>
  );
  private auctionsService: AuctionsService = inject(AuctionsService);

  auctionForm = new FormGroup(
      {
        name: new FormControl('', [Validators.required,
          Validators.pattern(/^[A-Za-z]{2,15}$/)]),
        description: new FormControl('', [Validators.required,
          Validators.pattern(/^[A-Za-z]{2,500}$/)]),
        photoUrl: new FormControl(),
        startPrice: new FormControl('', [Validators.required,
          Validators.min(1)]),
      }
  );

  public close(): void {
    this.dialogRef.close();
  }

  public onSubmit(): void {
    console.log(this.auctionForm.value);
    this.auctionsService.create(this.auctionForm.value).subscribe({
      next: () => {
        this.dialogRef.close();
      }, error: (error) => {
        console.log(error.error.message)
      }
    });
  }
}
