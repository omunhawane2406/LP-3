// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract BankAccount {

    uint public balance;

    // Deposit money
    function deposit() public payable {
        require(msg.value > 0, "Amount must be greater than zero");
        balance += msg.value;
    }

    // Withdraw money
    function withdraw(uint amount) public {
        require(amount > 0, "Invalid amount");
        require(amount <= balance, "Insufficient balance");

        balance -= amount;
        payable(msg.sender).transfer(amount);
    }

    // Show balance
    function showBalance() public view returns (uint) {
        return balance;
    }
}
