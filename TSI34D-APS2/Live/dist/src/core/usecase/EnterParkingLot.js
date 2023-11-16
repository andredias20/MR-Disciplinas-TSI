"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
class EnterParkingLot {
    constructor(parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;
    }
    async execute(code) {
        const parkingLot = await this.parkingLotRepository.getParkingLot(code);
        return parkingLot;
    }
}
exports.default = EnterParkingLot;
