import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Rx";
import {classToPlain, plainToClass} from "class-transformer";
import {map} from "rxjs/internal/operators";
import {RawResource} from "../model/tables/rawResource";
import {ResourceView} from "../model/view/resourceView";
import {UserView} from "../model/view/userView";
import {TypeTransactionView} from "../model/view/typeTransactionView";

@Injectable()
export class TypeTransactionService {

    constructor(private http: HttpClient) {
    }

    getTypeTransactionView(): Observable<TypeTransactionView[]> {
        return this.http.get<TypeTransactionView[]>("wallet/get-typeTransaction-view" )
            .pipe(
                map(response => plainToClass(TypeTransactionView, response as Object[])
                )
            );
    }

}