import { Component, inject } from "@angular/core";
import {
  MAT_DIALOG_DATA,
  MatDialogModule,
  MatDialogRef,
} from "@angular/material/dialog";
import { MatButtonModule } from "@angular/material/button";
import { MatInputModule } from "@angular/material/input";
import { PhotoPreviewComponent } from "../photo-preview/photo-preview.component";
import { ReactiveFormsModule } from "@angular/forms";
import { AuctionsService } from "../../services/auctions.service";
import { Auction } from "../../model/auction";
import { AuctionFormGroup } from "../../forms/auction-form-group";

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
  public data: { auction: Auction } = inject(MAT_DIALOG_DATA);

  auctionForm: AuctionFormGroup = new AuctionFormGroup();

  public close(): void {
    this.dialogRef.close();
  }

  public onSubmit(): void {
    this.auctionsService.update(this.auctionForm.value).subscribe({
      next: () => {
        this.dialogRef.close();
        this.auctionsService.reinitializeList();
      },
    });
  }
}
