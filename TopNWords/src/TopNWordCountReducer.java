import java.io.IOException; 
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class TopNWordCountReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
	public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
		/*Initial count will be 0 for a keyword*/
		int total = 0;
		for (IntWritable value: values) {
			/*Getting previous value and add new value in count*/
			total += value.get();
		}
		context.write(key, new IntWritable(total));
	}
}