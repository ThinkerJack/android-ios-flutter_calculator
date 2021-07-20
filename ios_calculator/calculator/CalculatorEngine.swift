//
//  CalculatorEngine.swift
//  calculator
//
//  Created by orangelab on 2021/7/19.
//

import UIKit

class CalculatorEngine: NSObject {
    let funcArray:CharacterSet = ["+","-","*","/","^","%"]
    func calculatEquation(equation:String)->Double{
        let elementArray = equation.components(separatedBy: funcArray)
        var tip = 0;
        var result:Double = Double(elementArray[0])!
        
        for char in equation{
            switch char{
            case "+":
                tip += 1
                if elementArray.count>tip{
                    result+=Double(elementArray[tip])!
                }
            case "-":
                tip += 1
                if elementArray.count>tip{
                    result-=Double(elementArray[tip])!
                }
            case "*":
                tip += 1
                if elementArray.count>tip{
                    result*=Double(elementArray[tip])!
                }
            case "/":
                tip += 1
                if elementArray.count>tip{
                    result/=Double(elementArray[tip])!
                }
            case "%":
                tip += 1
                if elementArray.count>tip{
                    result=Double(Int(result) % Int(elementArray[tip])!)
                }
            case "^":
                tip += 1
                if elementArray.count>tip{
                    let tmp = result
                    for _ in 1..<Int(elementArray[tip])!{
                        result*=tmp
                    }
                }
            
            default:
                break
            }
        }
        return result;
    }

}
