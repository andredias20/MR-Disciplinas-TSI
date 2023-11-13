"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const ParkingLot_1 = __importDefault(require("../../core/entity/ParkingLot"));
class ParkingLotRepositoryMemory {
    getParkingLot(code) {
        return Promise.resolve(new ParkingLot_1.default("shopping", 5, 8, 22));
    }
}
exports.default = ParkingLotRepositoryMemory;
