module down_counter(q, clk, rst);
  output [3:0]q;
  input clk, rst;
  reg [3:0]q;
  
  always @ (posedge clk or posedge rst)
  begin
    if (rst || q == 4'b0000)
      q <= 4'b1111;
    else
      q <= q - 1;
  end
endmodule

module down_counter_tb;
  wire [3:0]q;
  reg clk, rst;
  
  down_counter tb(q, clk, rst);
  
  always
  #5 clk = ~clk;
  
  initial
  begin
    clk = 0; rst = 1;
    #10 rst = 0;
    # 200 $stop;
  end
endmodule