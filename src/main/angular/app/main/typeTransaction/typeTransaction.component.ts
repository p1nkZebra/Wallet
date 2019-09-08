import {Component, OnInit} from '@angular/core';
import {finalize, tap} from "rxjs/operators";
import {TypeTransactionView} from "../../model/view/typeTransactionView";
import {TypeTransactionService} from "../../service/typeTransaction.service";

@Component({
    selector: 'typeTransaction',
    templateUrl: 'typeTransaction.component.html'
})
export class TypeTransactionComponent implements OnInit {

    allTypeTransactions: TypeTransactionView[] = [];
    selectedTypeTransactions: TypeTransactionView[] = [];

    constructor(private httpService: TypeTransactionService) {
    }

    ngOnInit() {

        this.updateTable();
    }

    updateTable() {
        this.httpService.getTypeTransactionView()
            .pipe(
                tap(() => {
                    // do something before all actions
                }),
                finalize(() => {
                    // do something after all actions
                })
            ).subscribe(
            response => {
                this.allTypeTransactions = response;
            },
            (error) => {
                console.log(error);
            });
    }
}