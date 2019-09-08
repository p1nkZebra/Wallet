import {RouterModule, Routes} from '@angular/router';
import {ModuleWithProviders} from "@angular/core";
import {UserComponent} from "./main/user/user.component";
import {TypeTransactionComponent} from "./main/typeTransaction/typeTransaction.component";


export const ROUTES: Routes = [
    {path: '', redirectTo: 'user', pathMatch: 'full'},
    {path: 'user', component: UserComponent},
    {path: 'type-transaction', component: TypeTransactionComponent},
    // {path: 'resource-table', component: ResourceTableComponent},
    // {path: 'contribution-table', component: ContributionTableComponent},
    // {path: 'event-table', component: EventTableComponent},
    // {path: 'resources-view', component: ResourceViewComponent},
    // {path: 'contributions-view', component: ContributionViewComponent},
    // {path: 'events-view', component: EventViewComponent},

    // {
    //     path: 'admin', component: AdminComponent, canActivate: [AuthGuard, RoleGuard],
    //     data: {expectedRoles: [Role.ADMIN]}
    // },
    // {path: '**', component: NotFoundPageComponent}
];

export const ROUTING: ModuleWithProviders = RouterModule.forRoot(ROUTES);
