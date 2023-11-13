export default class ParkingLot {
  code: any;
  capacity: any;
  closeHour: any;
  openHour: any;

  constructor(code, capatity, openHour, closeHour) {
    this.code = code;
    this.capacity = capatity;
    this.openHour = openHour;
    this.closeHour = closeHour;
  }
}
