import { Component, inject } from "@angular/core";
import {
  MAT_DIALOG_DATA,
  MatDialogModule,
  MatDialogRef,
} from "@angular/material/dialog";
import { MatButtonModule } from "@angular/material/button";
import { AuctionsService } from "../../services/auctions.service";

@Component({
  selector: "app-modal-delete-auction",
  standalone: true,
  imports: [MatDialogModule, MatButtonModule],
  templateUrl: "./modal-delete-auction.component.html",
  styleUrl: "./modal-delete-auction.component.scss",
})
export class ModalDeleteAuctionComponent {
  private dialogRef: MatDialogRef<ModalDeleteAuctionComponent> = inject(
    MatDialogRef<ModalDeleteAuctionComponent>
  );

  public data: { auctionId: number } = inject(MAT_DIALOG_DATA);
  private auctionsService: AuctionsService = inject(AuctionsService);

  public close(): void {
    this.dialogRef.close();
  }

  public onDelete(): void {
    this.auctionsService.delete(this.data.auctionId).subscribe({
      next: () => {
        this.dialogRef.close();
      },
    });
  }
}
