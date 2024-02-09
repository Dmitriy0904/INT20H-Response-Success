import {Component, inject, Input} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogModule, MatDialogRef} from "@angular/material/dialog";
import {MatButtonModule} from "@angular/material/button";
import {AuctionsService} from "../../services/auctions.service";
import {ModalService} from "../../services/modal.service";

@Component({
  selector: "app-modal-delete-auction",
  standalone: true,
  imports: [
    MatDialogModule,
    MatButtonModule,
  ],
  templateUrl: "./modal-delete-auction.component.html",
  styleUrl: "./modal-delete-auction.component.scss",
})
export class ModalDeleteAuctionComponent {
  private dialogRef: MatDialogRef<ModalDeleteAuctionComponent> = inject(
      MatDialogRef<ModalDeleteAuctionComponent>
  );

  public data: any = inject(MAT_DIALOG_DATA);
  private auctionsService: AuctionsService = inject(AuctionsService);

  public close(): void {
    this.dialogRef.close();
  }

  public onDelete(): void {
    this.auctionsService.delete(this.data.auctionId).subscribe({
      next: () => {
        this.dialogRef.close();
      }, error: (error) => {
        console.log(error.error.message)
      }
    });
  }
}
