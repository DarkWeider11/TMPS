using System;
using System.Collections.Generic;
using System.Text;

namespace Lab1.S
{
    public class PC2
    {
        private string company;
        private Videocard videocard;
        public PC2(string company, Videocard videocard)
        {
            this.company = company;
            this.videocard = videocard;
        }

        public void TurnOn()
        {
               Console.WriteLine("Turning on!");
               videocard.RenderImage();
        }

        public void TurnOff()
        {
            Console.WriteLine("Turning off!");
        }
    }
}
