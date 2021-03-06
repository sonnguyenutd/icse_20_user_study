@Override public void triangle(float x1,float y1,float x2,float y2,float x3,float y3){
  beforeContextDraw();
  if (drawingThinLines()) {
    x1+=0.5f;
    x2+=0.5f;
    x3+=0.5f;
    y1+=0.5f;
    y2+=0.5f;
    y3+=0.5f;
  }
  context.beginPath();
  context.moveTo(x1,y1);
  context.lineTo(x2,y2);
  context.lineTo(x3,y3);
  context.closePath();
  if (fill)   context.fill();
  if (stroke)   context.stroke();
}
