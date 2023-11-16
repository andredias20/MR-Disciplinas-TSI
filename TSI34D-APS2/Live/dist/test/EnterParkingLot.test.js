"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const EnterParkingLot_1 = __importDefault(require("../src/core/usecase/EnterParkingLot"));
const ParkingLotRepositoryMemory_1 = __importDefault(require("../src/infra/repository/ParkingLotRepositoryMemory"));
test("Should enter parking lot", async function () {
    const parkingLotRepositoryMemory = new ParkingLotRepositoryMemory_1.default();
    const enterParkingLot = new EnterParkingLot_1.default(parkingLotRepositoryMemory);
    const parkingLot = await enterParkingLot.execute("shopping");
    expect(parkingLot.code).toBe("shopping");
});
