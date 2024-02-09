import {Component, Inject, inject, Input} from "@angular/core";
import {MAT_DIALOG_DATA, MatDialogModule, MatDialogRef} from "@angular/material/dialog";
import { MatButtonModule } from "@angular/material/button";
import { MatInputModule } from "@angular/material/input";
import { PhotoPreviewComponent } from "../photo-preview/photo-preview.component";
import {FormControl, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {AuctionsService} from "../../services/auctions.service";
import {Auction} from "../../model/auction";
import {Observable} from "rxjs";
import {ModalService} from "../../services/modal.service";

@Component({
  selector: "app-modal-update-auction",
  standalone: true,
  imports: [
    MatDialogModule,
    MatButtonModule,
    MatInputModule,
    PhotoPreviewComponent,
    ReactiveFormsModule,
  ],
  templateUrl: "./modal-update-auction.component.html",
  styleUrl: "./modal-update-auction.component.scss",
})
export class ModalUpdateAuctionComponent {
  private dialogRef: MatDialogRef<ModalUpdateAuctionComponent> = inject(
      MatDialogRef<ModalUpdateAuctionComponent>
  );
  private auctionsService: AuctionsService = inject(AuctionsService);
  public modalService: ModalService = inject(ModalService);
  public data: any = inject(MAT_DIALOG_DATA);

  auctionForm = new FormGroup(
      {
        id: new FormControl(this.data.auction.id),
        name: new FormControl(this.data.auction.name, [Validators.required,
          Validators.pattern(/^[A-Za-z]{2,15}$/)]),
        description: new FormControl(this.data.auction.description, [Validators.required,
          Validators.pattern(/^[A-Za-z]{2,500}$/)]),
        photoUrl: new FormControl(),
        startPrice: new FormControl(this.data.auction.startPrice, [Validators.required,
          Validators.min(1)]),
      }
  );

  public close(): void {
    console.log(this.data.auction.name);
    this.dialogRef.close();
  }

  public onSubmit(): void {
    console.log(this.auctionForm.value);
    this.auctionsService.update(this.auctionForm.value).subscribe({
      next: () => {
        this.dialogRef.close();
      }, error: (error) => {
        console.log(error.error.message)
      }
    });
  }
}
