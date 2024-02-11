import { Component, OnDestroy, OnInit, inject } from "@angular/core";
import { AuctionCardComponent } from "../../components/auction-card/auction-card.component";
import { Auction } from "../../model/auction";
import { AuctionsService } from "../../services/auctions.service";
import { Subject, takeUntil } from "rxjs";
import { CommonModule } from "@angular/common";

@Component({
  selector: "app-auctions-page",
  standalone: true,
  imports: [CommonModule, AuctionCardComponent],
  templateUrl: "./auctions-page.component.html",
  styleUrl: "./auctions-page.component.scss",
})
export class AuctionsPageComponent implements OnInit, OnDestroy {
  private auctionsService: AuctionsService = inject(AuctionsService);
  private destroy$: Subject<void> = new Subject<void>();

  public auctions: Auction[] = [];

  ngOnInit(): void {
    this.getAll();
    this.handleReinitializeEvent();
  }

  ngOnDestroy(): void {
    this.destroy$.next();
    this.destroy$.complete();
  }

  private handleReinitializeEvent(): void {
    this.auctionsService.reinitializeList$
      .pipe(takeUntil(this.destroy$))
      .subscribe({
        next: () => this.getAll(),
      });
  }

  private getAll(): void {
    this.auctionsService
      .getAll()
      .pipe(takeUntil(this.destroy$))
      .subscribe({
        next: (auctions: Auction[]) => {
          this.auctions = auctions;
        },
      });
  }
}
