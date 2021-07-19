//
//  Board.swift
//  calculator
//
//  Created by orangelab on 2021/7/17.
//

import UIKit
import SnapKit
protocol BoardButtonInputDelegate {
    func  boardButtonClick(content:String)
}
class Board: UIView {

    /*
    // Only override draw() if you perform custom drawing.
    // An empty implementation adversely affects performance during animation.
    override func draw(_ rect: CGRect) {
        // Drawing code
    }
    */
    var dataArray = ["0",".","%","=","1","2","3","+","4","5","6","-","7","8","9","*","ac","del","^","/"]
    
    var delegate:BoardButtonInputDelegate?
    override init(frame: CGRect) {
        super.init(frame: frame)
        installUI()
    }
    required init?(coder aDecoder: NSCoder) {
        super.init(coder: aDecoder)
        installUI()
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
                if index/4 == 0{
                    maker.bottom.equalTo(0)
                }else if index%4 == 0{
                    maker.bottom.equalTo(frontBtn.snp.top)
                }else{
                    maker.bottom.equalTo(frontBtn.snp.bottom)
                }
                //等分 每一个btn占据父视图宽度的0.25
                maker.width.equalTo(btn.superview!.snp.width).multipliedBy(0.25)
                //等分 每一个btn占据父视图高度的0.2
                maker.height.equalTo(btn.superview!.snp.height).multipliedBy(0.2)
            })
            btn.tag = index+100
            btn.addTarget(self, action: #selector(btnClick(button:)), for: UIControl.Event.touchUpInside)
            btn.setTitle(dataArray[index], for: UIControl.State.normal)
            frontBtn = btn
        }
    }
    @objc func btnClick(button:FuncButton)  {
        if delegate != nil{
            delegate?.boardButtonClick(content: button.currentTitle!)
        }
    }
}
class Screen:UIView{
    var inputLabel:UILabel?
    var historyLabel:UILabel?
    var inputString=""
    var historyString=""
    let figureArray:Array<Character>  = ["0","1","2","3","4","5","6","7","8","9","."]
    let funcArray = ["+","-","*","/","%","^"]
    
   
    init(){
        inputLabel = UILabel()
        historyLabel = UILabel()
        super.init(frame: CGRect.zero)
        installUI()
    }
    required init?(coder aDecoder: NSCoder) {
        super.init(coder: aDecoder)
        installUI()
    }
    func installUI(){
        inputLabel?.textAlignment = .right
        historyLabel?.textAlignment = .right
        inputLabel?.font = UIFont.systemFont(ofSize: 34)
        historyLabel?.font = UIFont.systemFont(ofSize: 30)
        inputLabel?.textColor = UIColor.orange
        historyLabel?.textColor = UIColor.black
        inputLabel?.adjustsFontSizeToFitWidth = true
        inputLabel?.minimumScaleFactor = 0.5
        historyLabel?.adjustsFontSizeToFitWidth = true
        historyLabel?.minimumScaleFactor = 0.5
        inputLabel?.lineBreakMode = .byTruncatingHead
        historyLabel?.lineBreakMode = .byTruncatingHead
        inputLabel?.numberOfLines = 0
        historyLabel?.numberOfLines = 0
        self.addSubview(inputLabel!)
        self.addSubview(historyLabel!)
        inputLabel?.snp.makeConstraints({(maker) in
            maker.left.equalTo(10)
            maker.right.equalTo(-10)
            maker.bottom.equalTo(-10)
            maker.height.equalTo(inputLabel!.superview!.snp.height).multipliedBy(0.5).offset(-10)
        })
        historyLabel?.snp.makeConstraints({(maker) in
            maker.left.equalTo(10)
            maker.right.equalTo(-10)
            maker.bottom.equalTo(inputLabel!.snp.top)
            maker.height.equalTo(historyLabel!.superview!.snp.height).multipliedBy(0.5).offset(-10)
        })
    }
    func inputContent(content:String){
        if !figureArray.contains(content.last!) && !funcArray.contains(content){
            return
        }
        if inputString.count > 0{
            if figureArray.contains(inputString.last!){
                inputString.append(content)
                inputLabel?.text = inputString
            }else{
                if figureArray.contains(content.last!){
                    inputString.append(content)
                    inputLabel?.text = inputString
                }
            }
        }else{
            if figureArray.contains(content.last!){
                inputString.append(content)
                inputLabel?.text = inputString
            }
        }
    }
    
    func refreshHistory(){
        historyString = inputString
        historyLabel?.text = historyString
    }
    func clearContent(){
        inputString = ""
        inputLabel?.text = inputString
    }
    func deleteInput(){
        if inputString.count > 0 {
            inputString.remove(at: inputString.index(before: inputString.endIndex))
            inputLabel?.text = inputString
        }
    }

}
