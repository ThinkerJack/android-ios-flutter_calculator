//
//  FuncButton.swift
//  calculator
//
//  Created by orangelab on 2021/7/17.
//

import UIKit

class FuncButton: UIButton {
     init(){
        super.init(frame: CGRect.zero)
        self.layer.borderWidth = 0.5;
        self.layer.borderColor = UIColor(red: 219/255.0, green: 219/255.0, blue: 219/255.0, alpha: 1).cgColor
        self.setTitleColor(UIColor.orange, for: UIControl.State.normal)
        self.titleLabel?.font = UIFont.systemFont(ofSize: 25)
        self.setTitleColor(UIColor.black, for: UIControl.State.highlighted)
    }
    required init?(coder aDecoder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }

}
