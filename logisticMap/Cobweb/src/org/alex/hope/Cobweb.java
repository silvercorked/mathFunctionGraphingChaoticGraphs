package org.alex.hope;

import java.awt.*;

import java.applet.*;

import java.lang.*;

import java.text.*;

import java.util.*;

public class Cobweb extends Applet

{

	public void init() {

		setLayout(new BorderLayout());

		CobwebTimeSeriesCanvas dc = new CobwebTimeSeriesCanvas();

		CobwebCanvas c = new CobwebCanvas();

		add("West", c);

		add("East", dc);

		add("North", new CobwebControls(c, dc));

	}

}

class CobwebControls extends Panel {

	Label k1 = new Label("a");

	Label k2 = new Label("Initial Condition");

	Label k3 = new Label("Iteration Number");

	TextField a;

	TextField x0;

	TextField In;

	CobwebCanvas canvas1;

	CobwebTimeSeriesCanvas canvas2;

	public CobwebControls(CobwebCanvas canvas1, CobwebTimeSeriesCanvas canvas2) {

		this.canvas1 = canvas1;

		this.canvas2 = canvas2;

		add(k1);

		add(a = new TextField("3.9", 4));

		add(k2);

		add(x0 = new TextField("0.3", 4));

		add(k3);

		add(In = new TextField("10", 4));

		add(new Button("Draw"));

	}

	public boolean action(Event ev, Object arg) {

		if (ev.target instanceof Button) {

			String label = (String) arg;

			canvas1.redraw(Double.valueOf(a.getText().trim()).doubleValue(),

					Double.valueOf(x0.getText().trim()).doubleValue(),

					Double.valueOf(In.getText().trim()).doubleValue());

			canvas2.redrawer(Double.valueOf(a.getText().trim()).doubleValue(),

					Double.valueOf(x0.getText().trim()).doubleValue(),

					Double.valueOf(In.getText().trim()).doubleValue());

			return true;

		}

		return false;

	}

}

class CobwebCanvas extends Canvas {

	double fixed_a = 3.9, Initial_Condition = 0.3, Iteration_Number = 10;

	public CobwebCanvas() {

		resize(410, 280);

	}

	public void paint(Graphics g) {

		Logistic_Map ex = new Logistic_Map(g, fixed_a,

				Initial_Condition, Iteration_Number);

	}

	public void redraw(double a, double x0, double In) {

		fixed_a = a;

		Initial_Condition = x0;

		Iteration_Number = In;

		repaint();

	}

}

class Logistic_Map {

	double fixed_a;

	double Initial_Condition;

	double Iteration_Number;

	Logistic_Map(Graphics g, double a, double x0, double In) {

		double y2, y1, y0;

		double fixed_a = a;

		double Initial_Condition = x0;

		double Iteration_Number = In;

		double deltax = .0001;

		y0 = Initial_Condition;

		g.setColor(Color.black);

		// Make Axes and Label them

		g.drawLine(10, 10, 10, 260);

		g.drawLine(10, 260, 410, 260);

		g.drawString("1", 0, 15);

		g.drawString("0", 0, 255);

		g.drawString("0", 15, 270);

		g.drawString("1", 400, 270);

		// Make Function and Diagonal

		for (int i = 0; i < 10000; i++) {

			g.setColor(Color.black);

			g.drawLine((int) (400 * i * deltax) + 10,

					(int) (260 - 250 * (fixed_a * i * deltax * (1 - i * deltax))),

					(int) (400 * (i) * deltax) + 10,

					(int) (260 - 250 * (fixed_a * i * deltax * (1 - i * deltax))));

			g.setColor(Color.red);

			g.drawLine((int) (400 * i * deltax) + 10,

					(int) (260 - 250 * i * deltax),

					(int) (400 * (i) * deltax) + 10,

					(int) (260 - 250 * i * deltax));

		}

		// Draw Cobweb Diagram

		g.setColor(Color.blue);

		for (int i = 0; i <= Iteration_Number; i++) {

			y1 = (fixed_a * y0 * (1 - y0));

			y2 = (fixed_a * y1 * (1 - y1));

			g.drawLine((int) (400 * y0 + 10), (int) (260 - 250 * y1),

					(int) (400 * y1 + 10), (int) (260 - 250 * y1));

			g.drawLine((int) (400 * y1 + 10), (int) (260 - 250 * y1),

					(int) (400 * y1 + 10), (int) (260 - 250 * y2));

			y0 = y1;

			y1 = y2;

		}

	}

}

class CobwebTimeSeriesCanvas extends Canvas {

	double fixed_a = 3.9, Initial_Condition = 0.3, Iteration_Number = 10;

	public CobwebTimeSeriesCanvas() {

		resize(510, 270);

	}

	public void paint(Graphics g) {

		LogisticTimeSeries_Map ex = new LogisticTimeSeries_Map(g, fixed_a,

				Initial_Condition, Iteration_Number);

	}

	public void redrawer(double a1, double x0, double In) {

		fixed_a = a1;

		Initial_Condition = x0;

		Iteration_Number = In;

		repaint();

	}

}

class LogisticTimeSeries_Map {

	double fixed_a;

	double Initial_Condition;

	double Iteration_Number;

	LogisticTimeSeries_Map(Graphics g, double a, double x0, double In) {

		double y1, y0;

		double fixed_a = a;

		double Initial_Condition = x0;

		y0 = x0;

		double Iteration_Number = In;

		g.setColor(Color.black);

		// Draw and Label Axes

		g.drawLine(10, 10, 10, 260);

		g.drawLine(10, 260, 510, 260);

		g.drawString("1", 0, 15);

		g.drawString("0", 0, 255);

		g.drawString("x", 0, 120);

		g.drawString("0", 15, 270);

		g.drawString("" + Iteration_Number, 490, 270);

		g.drawString("Iteration Number", 240, 272);

		g.setColor(Color.magenta);

		for (int i = 0; i <= Iteration_Number; i++) {

			y1 = (fixed_a * y0 * (1 - y0));

			g.drawLine((int) ((500 / Iteration_Number) * i) + 10,

					(int) (260 - 260 * y0),

					(int) ((500 / Iteration_Number) * (i + 1)) + 10,

					(int) (260 - 260 * y1));

			y0 = y1;

		}

	}

}
