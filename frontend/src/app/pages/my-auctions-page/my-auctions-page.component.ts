import { CommonModule } from "@angular/common";
import { Component, inject, OnDestroy, OnInit } from "@angular/core";
import { AuctionCardComponent } from "../../components/auction-card/auction-card.component";
import { AuctionsService } from "../../services/auctions.service";
import { Auction } from "../../model/auction";
import { Subject, takeUntil } from "rxjs";

@Component({
  selector: "app-my-auctions-page",
  standalone: true,
  imports: [CommonModule, AuctionCardComponent],
  templateUrl: "./my-auctions-page.component.html",
  styleUrl: "./my-auctions-page.component.scss",
})
export class MyAuctionsPageComponent implements OnInit, OnDestroy {
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
