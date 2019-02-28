import {Vehicle} from "./vehicle.model";

export class Records{
    id: number;
    day: string;
    date: string;
    timeIn: string;
    timeOut : string;
    vehicle: Vehicle;
    constructor(id:number,day:string,date:string,timeIn:string,timeOut:string,vehicle:Vehicle){
        this.id=id;
        this.day=day;
        this.date=date;
        this.timeIn=timeIn;
        this.timeOut=timeOut;
        this.vehicle=vehicle;
    }
    
}