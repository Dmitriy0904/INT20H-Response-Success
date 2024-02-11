import { Component, inject } from "@angular/core";
import { MatDialogModule, MatDialogRef } from "@angular/material/dialog";
import { MatButtonModule } from "@angular/material/button";
import { MatInputModule } from "@angular/material/input";
import { PhotoPreviewComponent } from "../photo-preview/photo-preview.component";
import { ReactiveFormsModule } from "@angular/forms";
import { AuctionsService } from "../../services/auctions.service";
import { AuctionFormGroup } from "../../forms/auction-form-group";

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

  auctionForm: AuctionFormGroup = new AuctionFormGroup();

  public close(): void {
    this.dialogRef.close();
  }

  public onSubmit(): void {
    this.auctionsService.create(this.auctionForm.value).subscribe({
      next: () => {
        this.dialogRef.close();
        this.auctionsService.reinitializeList();
      },
    });
  }
}
