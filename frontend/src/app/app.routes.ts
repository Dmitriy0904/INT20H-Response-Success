import { Routes } from "@angular/router";

export const routes: Routes = [
  { path: "", pathMatch: "full", redirectTo: "home" },
  {
    path: "home",
    loadComponent: () =>
      import("./components/home/home.component").then((c) => c.HomeComponent),
    children: [
      { path: "", pathMatch: "full", redirectTo: "auctions" },
      {
        path: "auctions",
        loadComponent: () =>
          import("./pages/auctions-page/auctions-page.component").then(
            (c) => c.AuctionsPageComponent
          ),
      },
      {
        path: "my-auctions",
        loadComponent: () =>
          import("./pages/my-auctions-page/my-auctions-page.component").then(
            (c) => c.MyAuctionsPageComponent
          ),
      },
    ],
  },
  {
    path: "login",
    loadComponent: () =>
      import("./pages/login-page/login-page.component").then(
        (c) => c.LoginPageComponent
      ),
  },
  {
    path: "register",
    loadComponent: () =>
      import("./pages/register-page/register-page.component").then(
        (c) => c.RegisterPageComponent
      ),
  },
];
