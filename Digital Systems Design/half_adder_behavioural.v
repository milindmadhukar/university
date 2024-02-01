module half_adder_behavioural(A, B, S, C);
  input A, B;
  output S, C;
  reg S, C;
  always @ (A, B)
  begin
    if(A == 0 && B == 0) begin
      S = 0;
      C = 0;
    end
    else if (A == 0 && B == 1) begin
      S = 1;
      C = 0;
    end
    else if (A == 1 &&  B == 0) begin
      S = 1;
      C = 0;
    end
    else begin
      S = 1;
      C = 1;
    end
  end
endmodule
  
  module half_adder_behavioural_testbench;
    wire S, C;
    reg A, B;
    
    half_adder_behavioural tb(A, B, S, C);
    initial
    begin
         A = 0; B = 0;
     #10 A = 0; B = 1;
     #10 A = 1; B = 0;
     #10 A = 1; B = 1;
   end
   
   initial #40 $finish;
 endmodule