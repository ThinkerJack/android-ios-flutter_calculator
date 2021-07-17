//
//  Board.swift
//  calculator
//
//  Created by orangelab on 2021/7/17.
//

import UIKit
import SnapKit

class Board: UIView {

    /*
    // Only override draw() if you perform custom drawing.
    // An empty implementation adversely affects performance during animation.
    override func draw(_ rect: CGRect) {
        // Drawing code
    }
    */
    var dataArray = ["0",".","%","=","1","2","3","+","4","5","6","-","7","8","9","*","ac","del","^","/"]
    override init(frame: CGRect) {
        super.init(frame: frame)
        installUI()
    }
    required init?(coder aDecoder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    func installUI(){
        var frontBtn:FuncButton!
        for index in 0..<20{
            let btn = FuncButton()
            self.addSubview(btn)
            btn.snp.makeConstraints({(maker) in
                if index%4 == 0{
                    maker.left.equalTo(0)
                }else{
                    maker.left.equalTo(frontBtn.snp.right)
                }
            })
            frontBtn = btn
        }
    }
}
