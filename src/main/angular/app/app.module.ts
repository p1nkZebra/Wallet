import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {BrowserModule} from "@angular/platform-browser";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {NgModule} from "@angular/core";
import {HttpClientModule} from "@angular/common/http";
import {ClarityModule, ClrInputModule} from "@clr/angular";
import {AppComponent} from './app.component';
import {ROUTING} from "./app.routing";

import {registerLocaleData} from '@angular/common';
import localeRu from '@angular/common/locales/ru';
import {UserComponent} from "./main/user/user.component";
import {UserService} from "./service/user.service";
import {TypeTransactionComponent} from "./main/typeTransaction/typeTransaction.component";
import {TypeTransactionService} from "./service/typeTransaction.service";

registerLocaleData(localeRu);

@NgModule({
    declarations: [
        AppComponent,
        UserComponent,
        TypeTransactionComponent,

        // ResourceViewComponent,
        // ContributionViewComponent,
        // EventViewComponent,
        //
        // ResourceTableComponent,
        // ContributionTableComponent,
        // EventTableComponent,



        // ClrInputContainer,


    ],

    imports: [
        BrowserAnimationsModule,
        BrowserModule,
        FormsModule,
        ReactiveFormsModule,
        HttpClientModule,
        ClarityModule,
        ClrInputModule,
        ROUTING
    ],
    providers: [
        UserService,
        TypeTransactionService,
        // {provide: LOCALE_ID, useValue: 'ru'},
        // {provide: HTTP_INTERCEPTORS, useClass: ConfigurationInterceptor, multi: true},
        // {provide: HTTP_INTERCEPTORS, useClass: CustomHttpInterceptor, multi: true},
        // {provide: HTTP_INTERCEPTORS, useClass: BlobErrorHttpInterceptor, multi: true},
        // {provide: HTTP_INTERCEPTORS, useClass: UnauthorizedInterceptor, multi: true},
    ],
    bootstrap: [AppComponent]
})
export class AppModule {
}
