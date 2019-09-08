import {Component, OnInit} from '@angular/core';
import {RawResource} from "../../model/tables/rawResource";
import {ResourceService} from "../../service/resource.service";
import {finalize, tap} from "rxjs/operators";
import {UserView} from "../../model/view/userView";
import {UserService} from "../../service/user.service";

@Component({
    selector: 'user',
    templateUrl: 'user.component.html'
})
export class UserComponent implements OnInit {

    allUsers: UserView[] = [];
    selectedUsers: UserView[] = [];

    constructor(private httpService: UserService) {
    }

    ngOnInit() {

        this.updateTable();
    }

    updateTable() {
        this.httpService.getUserView()
            .pipe(
                tap(() => {
                    // do something before all actions
                }),
                finalize(() => {
                    // do something after all actions
                })
            ).subscribe(
            response => {
                this.allUsers = response;
            },
            (error) => {
                console.log(error);
            });
    }
}