import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {map} from "rxjs/internal/operators";
import {Observable} from "rxjs/Rx";
import {classToPlain, plainToClass} from "class-transformer";
import {ContributionView} from "../model/view/contributionView";
import {RawContribution} from "../model/tables/rawContribution";
import {RawResource} from "../model/tables/rawResource";


@Injectable()
export class ContributionService {

    constructor(private http: HttpClient) {
    }

    getContributionView(): Observable<ContributionView[]> {
        return this.http.get<ContributionView[]>("wallet/get-contribution-view")
            .pipe(
                map(response => plainToClass(ContributionView, response as Object[])
                )
            );
    }

    getContributionTable() {
        return this.http.get<RawContribution[]>("wallet/get-contribution-table" )
            .pipe(
                map(response => plainToClass(RawContribution, response as Object[])
                )
            );
    }


    addNewContribution(contribution: RawContribution) {
        return this.http.post("wallet/save-new-contribution", classToPlain(contribution));
    }

    editContribution(contribution: RawContribution) {
        return this.http.post("wallet/edit-contribution", classToPlain(contribution));

    }

    // loadResourceName(){
    //     return this.http.get<RawResource.name[]>()
    // }
}